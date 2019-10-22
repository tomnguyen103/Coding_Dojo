from django.conf.urls import url
from . import views


urlpatterns = [
    url(r'^$',views.index),
    url(r'^books$',views.books),
    url(r'^register$',views.register),
    url(r'^books$',views.books),
    url(r'^login$',views.login),
    url(r'^logout$', views.logout),
    url(r'^create_book_process$',views.create_book_process),
    url(r'^books/add$', views.new_book_review),
    url(r'^users/(?P<user_id>\d+)$',views.userpage),
    url(r'^books/(?P<book_id>\d+)$',views.showBook),
    url(r'^add_review/(?P<book_id>\d+)$',views.add_review),
    url(r'^delete_review/(?P<review_id>\d+)$',views.delete_review),
]
