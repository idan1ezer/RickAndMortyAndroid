sealed class Screen(val route: String) {
    object CharacterListScreen: Screen("char_list_screen")
    object CharacterDetailedScreen: Screen("char_detailed_screen")
}
