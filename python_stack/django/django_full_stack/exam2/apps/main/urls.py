from django.conf.urls import url
from . import views


urlpatterns = [
    url(r'^$',views.index),
    url(r'^register$',views.register),
    url(r'^login$',views.login),
    url(r'^logout$', views.logout),
    
    url(r'^dashboard$',views.dashboard),
    url(r'^create_trip_process$',views.create_trip_process),
    url(r'^trips/new$', views.new_trip),
    url(r'^trips/(?P<trip_id>\d+)$',views.trip_detail),
    url(r'^trips/edit/(?P<trip_id>\d+)$', views.edit),
    url(r'^update_trip/(?P<trip_id>\d+)$', views.update_trip),
    url(r'^trips/delete/(?P<trip_id>\d+)$',views.remove_trip),
    url(r'^trips/join/(?P<trip_id>\d+)$',views.join),
    url(r'^trips/cancel/(?P<trip_id>\d+)$', views.cancel_trip),
]
