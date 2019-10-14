from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.addBooks),
    url(r'^process', views.process),
    url(r'^book/(?P<id>\d+)$', views.book),
    url(r'^authors$', views.authors),
    url(r'^process$',views.process),
]
