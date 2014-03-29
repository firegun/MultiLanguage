// Callback pour la fonction d'authentification Google+
var signinCallback = function (authResult) {
    if (authResult['access_token']) {
        // Autorisation réussie
        // Masquer le bouton de connexion maintenant que l'utilisateur est autorisé, par exemple :
        document.getElementById('signinButtonGPlus').setAttribute('style', 'display: none');
        // Stocker le jeton renvoyé
        gapi.auth.setToken(authResult);
        // Récuprer les informations de l'utilisateur
        gapi.client.load('oauth2', 'v2', function() {
            var request = gapi.client.oauth2.userinfo.get();
            request.execute(userinfoCallback);
        });
    } else if (authResult['error']) {
        // Une erreur s'est produite.
        // Codes d'erreur possibles :
        //   "access_denied" - L'utilisateur a refusé l'accès à votre application
        //   "immediate_failed" - La connexion automatique de l'utilisateur a échoué
        document.getElementById('signinButtonGPlus').setAttribute('style', 'display: block');
    }
};

// Callback pour les informations de l'utilisateur Google+
var userinfoCallback = function (userinfo){
    //console.log(userinfo);
};