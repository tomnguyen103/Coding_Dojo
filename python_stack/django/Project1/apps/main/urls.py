from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.main),
    url(r'^about$', views.about),
    url(r'^books$', views.books),
    url(r'^product_single$', views.product_single),
    url(r'^faq$', views.faq),
    url(r'^register$', views.register),
    url(r'^login$', views.index),
    url(r'^logout$', views.logout),
    url(r'^privacy_policy$', views.privacy_policy),
    url(r'^terms_conditions$', views.terms_conditions),
    url(r'^products$', views.products),
]
