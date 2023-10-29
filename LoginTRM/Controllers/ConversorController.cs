using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using LoginTRM.Models;
using System.Net.Http.Headers;
using LoginTRM.Datos;

namespace LoginTRM.Controllers;

public class ConversorController : Controller
{
    MSTrm mSTrm = new MSTrm();
    public IActionResult Conversor(string usuario, string jwt)
    {
        if(jwt == null || jwt == "")
        {
            return Content("<script language='javascript' type='text/javascript'>alert('SIN ACCESO');</script>");
            //return NotFound();
        }
        Conversor conversor = new Conversor();
        conversor.usuario = usuario;
        conversor.jwt = jwt;
        return View(conversor);
    }

    public async Task<IActionResult> Moneda(Conversor conversor){
        IActionResult actionResult = null;
        List<MonedaRespuesta> monedaRespuestas = new List<MonedaRespuesta>();
        Moneda moneda = new Moneda();
        moneda.usuario = conversor.usuario;
        moneda.moneda = conversor.selMoneda;
        moneda.intercambio = conversor.selIntercambio;
        moneda.valor = (double.Parse(conversor.txtValor));

        monedaRespuestas = await mSTrm.Moneda(moneda, conversor.jwt);

        if(monedaRespuestas[0].successfull == true){
            TempData["resultado"] = monedaRespuestas[0].resultado.ToString();
            return RedirectToAction("Conversor", "Conversor", new { usuario = conversor.usuario, jwt = conversor.jwt });
        }
        else{
            return Content("<script language='javascript' type='text/javascript'>alert('" + monedaRespuestas[0].respuesta + "');</script>");
        }

    }
}
