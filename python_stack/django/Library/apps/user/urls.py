from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.show_main),
    url(r'^show_main$', views.index),
    url(r'^register$',views.register),
    url(r'^login$',views.index),
    url(r'^logout$', views.logout),
]