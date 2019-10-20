from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$',views.index),
    url(r'^process$',views.process),
    url(r'^register$',views.register),
    url(r'^dashboard$',views.dashboard),
    url(r'^login$',views.login),
    url(r'^logout$', views.logout),
    url(r'^jobs/new$',views.new_job),
    url(r'^jobs/edit/(?P<job_id>\d+)$',views.edit),
    url(r'^jobs/(?P<job_id>\d+)$', views.job),
    url(r'^jobs/add/(?P<job_id>\d+)$',views.add_job),
    url(r'^jobs/delete/(?P<job_id>\d+)$',views.delete_job),
]