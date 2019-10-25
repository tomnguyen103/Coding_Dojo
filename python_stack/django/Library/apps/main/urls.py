from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.main_index),
    url(r'^staff$', views.admin_index),
]