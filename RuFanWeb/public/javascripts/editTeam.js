$(document).ready(function() {
    $(".player-row").on("click", onPlayerRowClick);

    var baseUrl = window.location.protocol + '//' + window.location.host;
    $.get(baseUrl + '/api/teams', function(data) {
        var teams = $('#teamSelect');
        data.forEach(function(team) {
            teams.append('<option value="' + team.teamId + '">' + team.displayName + '<\/option>');
        });
    });
    // Auto-click first player
    $(".player-row:first").trigger("click");
});

var onPlayerRowClick = function() {
    var row = $(this);
    var Id = row.data("id");
    var posId = row.data("posid");

    initSelector(Id, posId);

    row.parent().find("*").removeClass("success");
    row.addClass("success");
};

var initSelector = function(id, posId) {
    $("#selection-container").data("id", id).data("posid", posId);
    $("#playerSelect").empty().append('<option value="-1">-- Select a player --<\/option>').off("change");
    $("#teamSelect").off("change").val(-1).on("change", onTeamChange);
};

var onTeamChange = function() {
    var selected = $("#teamSelect option:selected");
    var teamId = selected.val();
    var players = $("#playerSelect");
    players.empty().append('<option value="-1">-- Select a player --<\/option>');

    $.get("/api/players/" + teamId, function(data) {
       data.forEach(function(player) {
           players.append(
               '<option value="' + player.playerId + '">' + player.firstName + " " + player.lastName + '<\/option>'
           );
       });
    });

    players.on("change", onPlayerChange);
};

var onPlayerChange = function() {
    var selected = $("#playerSelect option:selected");
    var playerId = selected.val();
    var playerName = selected.html();

    var id = $("#selection-container").data("id");

    $("#display-" + id).html(playerName);
    $("#" + id).val(playerId);
};