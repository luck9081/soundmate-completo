function initialize() {
    var input = document.getElementById('ubicacion');

    var autocomplete = new google.maps.places.Autocomplete(input);

    google.maps.event.addListener(autocomplete, 'place_changed', function () {

        var place = autocomplete.getPlace();

        //document.getElementById('city2').value = place.name;
        //document.getElementById('txtLatitud').value = place.geometry.location.lat();
        //document.getElementById('txtLongitud').value = place.geometry.location.lng();
        
        document.getElementById('localidad').value = place.address_components[0].short_name;
        document.getElementById('partido').value = place.address_components[1].short_name;
        document.getElementById('provincia').value = place.address_components[2].long_name;
        
        //alert("This function is working!");
        //alert(place.name);
        //alert(place.address_components[0].short_name); 	// Localidad
        //alert(place.address_components[1].short_name); 	// Partido
        //alert(place.address_components[2].short_name); 	// Provincia
        //alert(place.address_components[3].short_name);	// Pais
        //alert(place.address_components[1].types[0]);

        /* MAPS PARA DIV
            var lat = place.geometry.location.lat(),
                lng = place.geometry.location.lng();

            var mapOptions = {
                center: new google.maps.LatLng(lat, lng),
                zoom: 12,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };

            var map = new google.maps.Map(document.getElementById("mapa"), mapOptions);

            var marker = new google.maps.Marker({
                position: new google.maps.LatLng(lat, lng),
                map: map,
                draggable: true,
            });
        */

    });

}

google.maps.event.addDomListener(window, 'load', initialize);