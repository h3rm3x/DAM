import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceProcessorTest {

    @ParameterizedTest
    @org.junit.jupiter.params.provider.ValueSource(strings = {"Factura1", "Factura2", "Factura3"})
    void processarFactura() {
        InvoiceProcessor invoiceProcessor = new InvoiceProcessor();
        String result = invoiceProcessor.processarFactura("Cliente Test", 100.0);

        assertNotNull(result);
        assertTrue(result.contains("Fact. per: Cliente Test"));
        assertTrue(result.contains("Import: 100.0"));
        assertTrue(result.contains("IVA (21%): 21.0"));
        assertTrue(result.contains("Total: 121.0"));
        assertThrows(IllegalArgumentException.class, () -> invoiceProcessor.processarFactura("Cliente Test", 0));
        assertThrows(IllegalArgumentException.class, () -> invoiceProcessor.processarFactura("Cliente Test", -50.0));

    }
    @ParameterizedTest
    @org.junit.jupiter.params.provider.ValueSource(doubles = {100.0, 200.0, 300.0})
    void processarFactura(double importeBruto) {
        InvoiceProcessor invoiceProcessor = new InvoiceProcessor();
        String result = invoiceProcessor.processarFactura("Cliente Test", importeBruto);

        assertNotNull(result);
        assertTrue(result.contains("Fact. per: Cliente Test"));
        assertTrue(result.contains("Import: " + importeBruto));
        assertTrue(result.contains("IVA (21%): " + (importeBruto * 0.21)));
        assertTrue(result.contains("Total: " + (importeBruto * 1.21)));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { " " })
    void processarFacturaWithInvalidClientName(String clientName) {
        InvoiceProcessor invoiceProcessor = new InvoiceProcessor();

        String result = invoiceProcessor.processarFactura(clientName, 100.0);

        assertNull(result, "Expected null result for invalid client name");
    }

}