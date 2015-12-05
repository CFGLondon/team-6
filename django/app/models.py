from django.db import models
from django.contrib.auth.models import User

class Constituent(models.Model):
	user = models.OneToOneField(User)
	address = models.CharField(max_length=500)
	interests = models.CharField(max_length=500)
	black = models.CharField(max_length=500)
	white = models.CharField(max_length=500)
	#date = models.DateField()
	
	def __unicode__(self):
		return self.name

class Volunteer(models.Model):
	user = models.OneToOneField(User)
	address = models.CharField(max_length=500)
	interests = models.CharField(max_length=500)
	black = models.CharField(max_length=500)
	white = models.CharField(max_length=500)
	#date = models.DateField()
	reference1number = models.IntegerField()
	reference1name = models.CharField(max_length=255)
	reference2number = models.IntegerField()	
	reference2name = models.CharField(max_length=255)

	def __unicode__(self):
		return self.name