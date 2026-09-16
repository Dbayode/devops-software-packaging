import os
from django.http import JsonResponse
from django.urls import path

def health_check(request):
    return JsonResponse({
        "status": "UP",
        "ecosystem": "Python/Django",
        "environment": os.getenv("APP_ENV", "development"),
        "debug_mode": os.getenv("DEBUG", "False").lower() == "true"
    })

urlpatterns = [
    path('health/', health_check),
]
