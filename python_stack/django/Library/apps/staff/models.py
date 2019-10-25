from django.db import models
from django.core.validators import validate_email
from datetime import datetime, date
import bcrypt

# Create your models here.
class StaffManager(models.Manager):
    def basic_validator(self,post_data):
        errors = {}
        if len(post_data["first_name"]) < 3:
            errors["first_name"] = "Please enter more than 2 characters for First Name!"
        if len(post_data["last_name"]) < 3:
            errors["last_name"] = "Please enter more than 2 characters for Last Name!"
        try:
            validate_email(post_data["staff_email"])
        except:
            errors["staff_email"] = "Please enter a valid email!"
        if len(post_data["staff_password"]) < 8:
            errors["staff_password"] = "Please enter at least 8 characters for Password!"
        
        if post_data["staff_password"] != post_data["staff_pw_confirm"]:
            errors["staff_pw_confirm"] = "Please ensure the password matched for confirmation"
        
        if len(post_data["staff_id"]) < 1:
            errors["staff_id"] = "Please enter your  Staff ID number!"
        elif len(post_data["staff_id"]) < 10:
            errors["staff_id"] = "Please ensure Staff ID number has 9 numbers!"
        
        staff_email = Staff.objects.filter(email=post_data['staff_email'])
        if len(staff_email) != 0:
            errors["staff_email"] = "This email already registered!"

        # staff_id = Staff.objects.filter(staff_id=post_data['staff_id'])
        # if len(str(staff_id)) != 0:
        #     errors["staff_id"] = "You already registered with this Staff ID number!"
        return errors

    def login_validation(self, post_data):
        staff = Staff.objects.filter(email = post_data['staff_login_email'])
        # user_id = Staff.objects.filter(staff_id = post_data['staff_login_id'])

        errors = {}
        if len(post_data["staff_login_email"])<1:
            errors["staff_login_email"] = "Please enter Your Email or Create new User!"
        elif not staff:
            errors['staff_email'] = "No user Found! Please Create New User"

        # if len(post_data["staff_login_id"])<1:
        #     errors["staff_login_id"] = "Please enter Your ID or Create new User!"
        # elif not staff:
        #     errors['staff_email'] = "No user Found! Please Create New User"

        if staff and not bcrypt.checkpw(post_data['staff_login_password'].encode('utf8'), staff[0].password.encode('utf8')):
            errors['staff_password'] = "Invalid email or password!"
        return errors

class Staff(models.Model):
    first_name= models.CharField(max_length=255)
    last_name= models.CharField(max_length=255)
    staff_id = models.IntegerField()
    email= models.EmailField(max_length=255)
    password= models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = StaffManager()

    def __str__(self):
        return (self.first_name+" "+self.last_name)
    