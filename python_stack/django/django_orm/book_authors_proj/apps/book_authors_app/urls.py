from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.addBooks),
    url(r'^process', views.process),
    url(r'^books/(?P<number>\d+)$', views.book),
    url(r'^add_author/(?P<number>\d+)$', views.addAuthor),
    url(r'^authors$', views.addAuthors),
    url(r'^process2$',views.process2),
    url(r'^authors/(?P<number>\d+)$', views.author),
    url(r'^add_book/(?P<number>\d+)$', views.addBook),
]
