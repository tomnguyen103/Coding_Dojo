from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index),
    url(r'^register$', views.register),
    url(r'^success$', views.success),
    url(r'^login$', views.login),
    url(r'^logout$', views.logout),
    url(r'^add_message$', views.add_message),
    url(r'^add_comment$', views.add_comment),
    url(r'^message/delete/(?P<id>\d+)$', views.delete_message),
    url(r'^comment/delete/(?P<id>\d+)$', views.delete_comment),
]
