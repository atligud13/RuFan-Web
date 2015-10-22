$(document).ready(function() {
    var dropdown = $("#favTeam");
    var baseUrl = window.location.protocol + '//' + window.location.host;

    $.get(baseUrl + '/api/teams', function(data) {
        data.forEach(function(item) {
            dropdown.append('<option value="' + item.teamId + '">' + item.displayName + '<\/option>');
        });
    });
});