from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$',views.index),
    url(r'^register$',views.register),
    url(r'^dashboard$',views.dashboard),
    url(r'^login$',views.login),
    url(r'^logout$', views.logout),
    url(r'^jobs/new$',views.new_job),
    url(r'^create_job_process$',views.create_job_process),
    url(r'^edit_job/(?P<job_id>\d+)$',views.edit_job),
    url(r'^update_job/(?P<job_id>\d+)$',views.update_job),
    url(r'^delete_job/(?P<job_id>\d+)$',views.delete_job),
    url(r'^jobs/(?P<job_id>\d+)$', views.job),
    url(r'^add_job_to_user/(?P<job_id>\d+)$',views.add_job_to_user),
    url(r'^give_up_job/(?P<job_id>\d+)$',views.give_up_job),
]