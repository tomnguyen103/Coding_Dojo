from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index),
    url(r'^process$',views.process),
    url(r'^dashboard$', views.dashboard),
    url(r'^users$',views.register),
    url(r'^login$',views.login),
    url(r'^logout$',views.logout),

]
