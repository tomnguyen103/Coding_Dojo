from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$',views.index),
    url(r'^shows$',views.shows),
    url(r'^shows/new$',views.new_shows),
    url(r'^shows/new/add$',views.add_new_shows),
    url(r'^shows/(?P<show_id>\d+)$',views.display_show),
]
