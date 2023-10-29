using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using LoginTRM.Models;
using System.Net.Http.Headers;
using LoginTRM.Datos;

namespace LoginTRM.Controllers;

public class HomeController : Controller
{
    MSAuth msAuth = new MSAuth();

    public IActionResult Login()
    {
        return View();
    }

    public async Task<IActionResult> IniciarSesion(string username, string contrasenya){
        IActionResult actionResult = null;
        Usuario usuario = new Usuario();
        usuario.usuario = username;
        usuario.contrasenya = contrasenya;

        if(username == null || contrasenya == null){
            return Content("<script language='javascript' type='text/javascript'>alert('hay campos vacíos!');</script>");
        }
        
        List<TokenRespuesta> tokenRespuesta = new List<TokenRespuesta>();

        tokenRespuesta = await msAuth.IniciarSesion(usuario);

        if(tokenRespuesta[0].successfull == true){
            //accionName, controllerName, Objects
            actionResult = RedirectToAction("Conversor", "Conversor", new { idUsuario = tokenRespuesta[0].idUsuario, jwt = tokenRespuesta[0].token });
        }
        else{
            return Content("<script language='javascript' type='text/javascript'>alert('" + tokenRespuesta[0].respuesta + "');</script>");
        }

        return actionResult;

    }
    
    private readonly ILogger<HomeController> _logger;

    public HomeController(ILogger<HomeController> logger)
    {
        _logger = logger;
    }
    public IActionResult Index()
    {
        return View();
    }

    public IActionResult Privacy()
    {
        return View();
    }

    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }
}
