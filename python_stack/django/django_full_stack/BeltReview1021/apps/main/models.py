from django.db import models
from django.core.validators import validate_email
from datetime import datetime, date
import bcrypt

# Create your models here.
class UserManager(models.Manager):
    def basic_validator(self,post_data):
        errors = {}
        if len(post_data["name"]) < 3:
            errors["name"] = "Please enter more than 2 characters for Name!"
        if len(post_data["alias"]) < 3:
            errors["alias"] = "Please enter more than 2 characters for Alias!"
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

    def login_validation(self, post_data):
        user = User.objects.filter(email = post_data['login_email'])
        errors = {}
        if not user:
            errors['email'] = "Invalid email or password!"

        if user and not bcrypt.checkpw(post_data['login_password'].encode('utf8'), user[0].password.encode('utf8')):
            errors['password'] = "Invalid email or password!"
        return errors

class User(models.Model):
    name= models.CharField(max_length=255)
    alias= models.CharField(max_length=255)
    email= models.EmailField(max_length=255)
    password= models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = UserManager()

class BookManager(models.Manager):
    def book_validation(self,post_data):
        errors = {}

        if len(post_data["title"]) < 1:
            errors["title"] = "Please enter a title!"
        elif len(post_data["title"]) < 3:
            errors["title"] = "Please enter a title of at least 3 characters!"
        # if len(post_data["author"]) < 1:
        #     errors["author"] = "Please provide the author!"
        # elif len(post_data["author"]) < 3:
        #     errors["author"] = "Please enter a author at least 3 characters!"
        # if post_data['author'] == "Please select":
        #     errors["author"] = "Please select from drop list!"
        # elif post_data["author"] == "":
        #     errors["author"] = "Please enter the author name!"
        if post_data['author1'] == "Please select":
            if post_data["author2"] == "":
                errors["author"] = "Please select from drop list or enter in the dropdown!"
                # post_data["author1"] = post_data["author"]
            
        return errors
    
# Create your models here.
class Book(models.Model):
    title = models.CharField(max_length=255)
    author = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = BookManager()

class Review(models.Model):
    review = models.TextField()
    rating = models.IntegerField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    reviewer = models.ForeignKey(User, related_name="reviews")
    book = models.ForeignKey(Book, related_name="book_reviews")