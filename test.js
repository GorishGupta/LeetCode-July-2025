fetch('https://ipapi.co/json/')
  .then(response => response.json())
  .then(data => {
    const latitude = data.latitude;
    const longitude = data.longitude;
    console.log('Latitude:', latitude);
    console.log('Longitude:', longitude);
  })
  .catch(error => {
    console.error('Error fetching data:', error);
  });
