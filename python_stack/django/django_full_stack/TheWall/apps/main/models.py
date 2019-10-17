from django.db import models
from django.contrib import messages
from django.core.validators import validate_email

# Create your models here.

class User(models.Model):
    first_name= models.CharField(max_length=255)
    last_name= models.CharField(max_length=255)
    email= models.EmailField(max_length=255)
    password= models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __repr__(self):
        return f"<User object: {self.first_name} {self.last_name}>"

class Message(models.Model):
    message= models.TextField()
    user= models.ForeignKey(User, related_name="messages")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

class Comment(models.Model):
    comment = models.TextField()
    message= models.ForeignKey(Message, related_name="m_comments")
    user = models.ForeignKey(User, related_name="u_comments")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
