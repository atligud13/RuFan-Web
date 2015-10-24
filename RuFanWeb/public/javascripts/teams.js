$(document).ready(function() {
    var dropdown = $("#favTeam");
    var baseUrl = window.location.protocol + '//' + window.location.host;
    var oldId = parseInt($("#favTeamId").val());

    $.get(baseUrl + '/api/teams', function(data) {
        data.forEach(function(item) {
            dropdown.append('<option value="' + item.teamId
                + '"' + (item.teamId === oldId ? 'selected="selected"' : '') +
                '>' + item.displayName + '<\/option>');
        });
    });
});