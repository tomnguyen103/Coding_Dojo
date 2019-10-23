from django.db import models
from django.core.validators import validate_email
from datetime import datetime, date
import bcrypt

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

    def login_validation(self, post_data):
        user = User.objects.filter(email = post_data['login_email'])
        errors = {}
        if len(post_data["login_email"])<1:
            errors["login_email"] = "Please enter Your Email or Create new User!"
        elif not user:
            errors['email'] = "No user Found! Please Create New User"
        if user and not bcrypt.checkpw(post_data['login_password'].encode('utf8'), user[0].password.encode('utf8')):
            errors['password'] = "Invalid email or password!"
        return errors

class User(models.Model):
    first_name= models.CharField(max_length=255)
    last_name= models.CharField(max_length=255)
    email= models.EmailField(max_length=255)
    password= models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = UserManager()

class TripManager(models.Manager):
    def trip_validation(self,post_data):
        errors = {}

        if len(post_data["destination"]) < 1:
            errors["destination"] = "Please enter a destination!"
        elif len(post_data["destination"]) < 3:
            errors["destination"] = "Please enter a destination of at least 3 characters!"
        if len(post_data["start_date"]) < 1:
            errors["start_date"] = "Please provide the start date!"
        if str(date.today()) > str(post_data['start_date']):
            errors["start_date"] = "Please input a valid Date. Note: Start time can not be in the past."
        
        if len(post_data["end_date"]) < 1:
            errors["end_date"] = "Please provide the end date!"
        if str(date.today()) > post_data['end_date']:
            errors["end_date"]=  "Please input a valid Date. Note: End date must be in the future"
        if post_data['start_date'] > post_data['end_date']:
            errors["end_date"] = "Travel Date From can not be in the future of Travel Date To"

        if len(post_data["plan"])<1:
            errors["plan"] = "A Plan must be provided"
        elif len(post_data["plan"]) < 3:
            errors["plan"] = "Please enter a plan of at least 3 characters!"
    
        return errors

    def update_trip_validation(self,post_data):
        errors = {}

        if len(post_data["destination"]) < 1:
            errors["destination"] = "Please enter a destination!"
        elif len(post_data["destination"]) < 3:
            errors["destination"] = "Please enter a destination of at least 3 characters!"
        if len(post_data["start_date"]) < 1:
            errors["start_date"] = "Please provide the start date!"
        if str(date.today()) > str(post_data['start_date']):
            errors["start_date"] = "Please input a valid Date. Note: Start time can not be in the past."
        
        if len(post_data["end_date"]) < 1:
            errors["end_date"] = "Please provide the end date!"
        if str(date.today()) > post_data['end_date']:
            errors["end_date"]=  "Please input a valid Date. Note: End date must be in the future"
        if post_data['start_date'] > post_data['end_date']:
            errors["end_date"] = "Travel Date From can not be in the future of Travel Date To"

        if len(post_data["plan"])<1:
            errors["plan"] = "A Plan must be provided"
        elif len(post_data["plan"]) < 3:
            errors["plan"] = "Please enter a plan of at least 3 characters!"
    
        return errors
    
    def join(self,id,trip_id):
        errors={}

        if len(Trip.objects.filter(id=trip_id).filter(creator=id))>0:
            errors["join"]= "You already joined" 
        else:
            joiner = User.objects.get(id=id)
            plan = self.get(id=trip_id)
            plan.join.add(joiner)
            return {}
    
# Create your models here.
class Trip(models.Model):
    destination = models.CharField(max_length=255)
    start_date = models.DateField(null=False)
    end_date = models.DateField(null=False)
    plan = models.TextField()
    creator = models.ForeignKey(User,related_name="planner")
    join = models.ManyToManyField(User,related_name="joiner")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = TripManager()
