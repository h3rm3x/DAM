public class InvoiceProcessor {
    public String processarFactura(String NombreCliente, double importeBruto) {
        if (NombreCliente == null || NombreCliente.isBlank()) {
            return null;
        }

        if (importeBruto <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }

        return calcularImporteNeto(NombreCliente, importeBruto);
    }

    private static String calcularImporteNeto(String NombreCliente, double importeBruto) {
        double porcentaje_IVA = 0.21;
        double IVA_anadido = importeBruto * porcentaje_IVA;
        double importeNeto = importeBruto + IVA_anadido;

        String Factura = "Fact. per: " + NombreCliente + "\n"
                + "Import: " + importeBruto + "\n"
                + "IVA (21%): " + IVA_anadido + "\n"
                + "Total: " + importeNeto;

        System.out.println(Factura);
        return Factura;
    }
}