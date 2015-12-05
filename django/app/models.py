from django.db import models
from django.contrib.auth.models import User

class Constituent(models.Model):
	user = models.OneToOneField(User)
	
	

	def __unicode__(self):
		return self.name