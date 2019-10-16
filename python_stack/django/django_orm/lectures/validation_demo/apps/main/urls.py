from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index),
    url(r'^process$',views.process),
    url(r'^dashboard$', views.dashboard),
    url(r'^users$',views.register),
    url(r'^login$',views.login),
    url(r'^logout$',views.logout),
    url(r'^movies/new$',views.new_movie),
    url(r'^movies/(?P<movie_id>\d+)$',views.single_movie),
    url(r'^movies/(?P<movie_id>\d+)/edit$',views.edit),
    url(r'^movies/(?P<movie_id>\d+)/delete$',views.delete),
    url(r'^movies/(?P<movie_id>\d+)/update$',views.update_movie),
]
