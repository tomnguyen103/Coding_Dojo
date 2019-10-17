from django.db import models

# Create your models here.

class User(models.Model):
    first_name= models.CharField(max_length=255)
    last_name= models.CharField(max_length=255)
    email= models.EmailField(max_length=255)
    password= models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

class Message(models.Model):
    message= models.TextField()
    user= models.ForeignKey(User, related_name="messages")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

class Comment(models.Model):
    