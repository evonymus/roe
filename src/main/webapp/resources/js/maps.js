function showPosition(lat, lon) {
    var latlon = lat + "," + lon;

    //var img_url = "http://maps.googleapis.com/maps/api/staticmap?center="
    //+latlon+"&zoom=14&size=400x300&sensor=false";

    var img_url = "http://maps.googleapis.com/maps/api/staticmap?center="
    +latlon+"&zoom=14&size=600x400&sensor=true&markers=color:blue%7Clabel:L%7C"+ latlon;

    document.getElementById("mapholder").innerHTML = "<img src='"+img_url+"'>";
}
