from django.db import models

# Create your models here.
class UserManager(models.Manager):
    def basic_validator(self, post_data):
        errors = {}
        if len(post_data["name"]) < 3:
            errors["name"] = "Please enter more than 2 characters for Name!"
        if not post_data["name"].isalpha():
            errors["name"] = "First Name should be alphabec only!"
        if len(post_data["alias"]) < 3:
            errors["alias"] = "Please enter more than 2 characters for alias Name!"
        if not post_data["alias"].isalpha():
            errors["alias"] = "alias Name should be alphabec only!"
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
    name = models.CharField(max_length=255)
    alias = models.CharField(max_length=255)
    email = models.EmailField(max_length=255)
    password = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = UserManager()


class Book(models.Model):
    title = models.TextField()
    message = models.ForeignKey(Message, related_name="m_comments")
    user = models.ForeignKey(User, related_name="u_comments")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UserManager()