package is.rufan.team.service;

import is.rufan.team.domain.Team;

import java.util.List;

public interface TeamService
{
  void addTeam(Team team) throws TeamServiceException;
  List<Team> getTeams();
  Team getTeamByAbbrivation(String abbrivation);
}
