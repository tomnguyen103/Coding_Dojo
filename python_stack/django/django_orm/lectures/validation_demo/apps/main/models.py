from django.db import models

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