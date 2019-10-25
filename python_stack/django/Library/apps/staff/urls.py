from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.staff_index),
    url(r'^staff_register$',views.staff_register),
    url(r'^staff_login$',views.staff_login),
    url(r'^staff_logout$', views.staff_logout),
]