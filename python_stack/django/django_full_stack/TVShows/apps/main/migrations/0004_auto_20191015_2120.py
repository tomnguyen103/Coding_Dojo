# -*- coding: utf-8 -*-
# Generated by Django 1.10 on 2019-10-15 21:20
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('main', '0003_auto_20191015_2117'),
    ]

    operations = [
        migrations.AlterField(
            model_name='show',
            name='desc',
            field=models.TextField(blank=True, null=True),
        ),
    ]
