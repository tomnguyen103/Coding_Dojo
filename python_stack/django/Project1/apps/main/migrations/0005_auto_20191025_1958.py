# -*- coding: utf-8 -*-
# Generated by Django 1.10 on 2019-10-25 19:58
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('main', '0004_auto_20191025_1803'),
    ]

    operations = [
        migrations.AlterField(
            model_name='book',
            name='users',
            field=models.ManyToManyField(blank=True, related_name='books', to='main.User'),
        ),
    ]
