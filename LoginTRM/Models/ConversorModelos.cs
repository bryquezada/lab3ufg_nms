namespace LoginTRM.Models;

public class ConversorModelos
{}

public class Moneda{
    public string? usuario{ get; set; }
    public string? moneda{ get; set; }
    public string? intercambio{ get; set; }
    public double? valor{ get; set; }
}

public class MonedaRespuesta
{
    public double? cantidad{ get; set; }
    public double? resultado{ get; set; }
    public bool? successfull{ get; set; }
    public string? respuesta{ get; set; }

}

public class Conversor{
    public string? usuario{ get; set; }
    public string? jwt{ get; set; }
    public string? txtValor{ get; set; }
    public string? selMoneda{ get; set; }
    public string? selIntercambio{ get; set; }
}


