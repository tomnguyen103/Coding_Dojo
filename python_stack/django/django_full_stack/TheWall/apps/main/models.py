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

    def __repr__(self):
        return f"<User object: {self.first_name} {self.last_name}>"

class Message(models.Model):
    message= models.TextField()
    user= models.ForeignKey(User, related_name="messages")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UserManager()

class Comment(models.Model):
    comment = models.TextField()
    message= models.ForeignKey(Message, related_name="m_comments")
    user = models.ForeignKey(User, related_name="u_comments")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UserManager()