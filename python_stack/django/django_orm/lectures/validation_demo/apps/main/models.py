from django.db import models
from django.core.validators import validate_email

class MovieManager(models.Manager):
    def basic_validator(self,post_data):
        errors = {}

        if len(post_data["title"]) < 1:
            errors["title"] = "Please enter a title!"
        elif len(post_data["title"]) < 5:
            errors["title"] = "Please enter a title of at least 5 characters!"
        if len(post_data["description"]) < 1:
            errors["description"] = "Please provide the description!"
        elif len(post_data["description"]) < 10:
            errors["description"] = "Please enter at least 10 characters for description!"
        try:
            if int(post_data["year"]) < 1900:
                errors["year"] = "Please enter a year of 1900 or beyond!"
        except:
            errors["year"] = "Please enter an integer!"

        return errors

# Create your models here.
class Movie(models.Model):
    title = models.CharField(max_length=255)
    description = models.TextField()
    year = models.IntegerField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    
    objects = MovieManager()

class UserManager(models.Manager):
    def basic_validator(self,post_data):
        errors = {}

        if len(post_data["first_name"]) < 2:
            errors["first_name"] = "Please enter at least 2 characters for your first name!"
        if len(post_data["last_name"]) < 2:
            errors["last_name"] = "Please enter at least 2 characters for your last name!"

        try:
            validate_email(post_data["email"])
        except:
            errors["email"] = "Please enter a valid email!"
        
        if len(post_data["password"]) < 8:
            errors["password"] = "Please enter a password of at least 8 characters."
        
        if post_data["password"] != post_data["pw_confirm"]:
            errors["pw_confirm"] = "Please ensure your password matches the confirmation."
        return errors
        
class User(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.EmailField(max_length=255)
    password = models.CharField(max_length=64)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = UserManager()