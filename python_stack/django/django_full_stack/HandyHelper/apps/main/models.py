from django.db import models
from django.core.validators import validate_email
from datetime import datetime, date

# Create your models here.
class UserManager(models.Manager):
    def basic_validator(self,post_data):
        errors = {}
        if len(post_data["first_name"]) < 3:
            errors["first_name"] = "Please enter more than 2 characters for First Name!"
        if len(post_data["last_name"]) < 3:
            errors["last_name"] = "Please enter more than 2 characters for Last Name!"
        try:
            validate_email(post_data["email"])
        except:
            errors["email"] = "Please enter a valid email!"
        if len(post_data["password"]) < 8:
            errors["password"] = "Please enter at least 8 characters for Password!"
        
        if post_data["password"] != post_data["pw_confirm"]:
            errors["pw_confirm"] = "Please ensure the password matched for confirmation"

        user_email = User.objects.filter(email=post_data['email'])
        if len(user_email) != 0:
            errors["email"] = "This email already registered!"
        return errors

class User(models.Model):
    first_name= models.CharField(max_length=255)
    last_name= models.CharField(max_length=255)
    email= models.EmailField(max_length=255)
    password= models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = UserManager()

class JobManager(models.Manager):
    def basic_validator(self,post_data):
        errors = {}

        if len(post_data["title"]) < 1:
            errors["title"] = "Please enter a title!"
        elif len(post_data["title"]) < 3:
            errors["title"] = "Please enter a title of at least 3 characters!"
        if len(post_data["description"]) < 1:
            errors["description"] = "Please provide the description!"
        elif len(post_data["description"]) < 3:
            errors["description"] = "Please enter a description at least 3 characters!"
        if len(post_data["location"]) < 1:
            errors["location"] = "Please provide the location!"
        elif len(post_data["location"]) < 3:
            errors["location"] = "Please enter a location at least 3 characters!"

        return errors

# Create your models here.
class Job(models.Model):
    title = models.CharField(max_length=255)
    description = models.TextField()
    location = models.CharField(max_length=255)
    user_created= models.ForeignKey(User, related_name="user_created")
    user_doing_job = models.ForeignKey(User, related_name="user_doing_job")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = JobManager()