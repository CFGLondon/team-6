from django import forms
from rango.models import Constituent, Volunteer

class VolunteerFoarm(forms.ModelForm):
	address = forms.CharField(max_length=128, help_text="Address:")

	class Meta:
		model = Volunteer
		fields = ('name',)