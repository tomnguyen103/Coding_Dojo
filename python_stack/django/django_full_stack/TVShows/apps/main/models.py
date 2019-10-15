from django.db import models
from datetime import date, datetime

# Create your models here.
class ShowManager(models.Manager):
    def basic_validator(self, post_data):
        errors = {}

        if len(post_data["title"]) < 2:
            errors["title"] = "Please enter at least 2 characters for Title!"
        if len(post_data["network"]) < 3:
            errors["network"] = "Please enter at least 3 characters for Network!"
        if len(post_data["release_date"]) >0 and datetime.strptime(post_data["release_date"], '%Y-%m-%d')> datetime.today():
            errors["release_data"] = "Please enter the date in the past!"
        if (post_data["desc"] and len(post_data["desc"]) < 10):
            errors["desc"] = "Please enter at least 10 characters for the Description!"
        return errors
    
class Show(models.Model):
    title = models.CharField(max_length=255)
    network = models.CharField(max_length=45)
    release_date = models.DateField()
    desc = models.TextField(blank=True)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = ShowManager()

