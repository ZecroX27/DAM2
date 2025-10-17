-- --------------------------------------------------------
-- Clientes que han hecho compras los últimos X días (Función)
-- 

CREATE OR REPLACE FUNCTION compras_clientes(dias INT)
RETURNS INTEGER AS $$
DECLARE
    num INTEGER;
BEGIN
    SELECT count(*) INTO num 
    FROM clientes 
    WHERE id IN (
        SELECT cliente 
        FROM facturas 
        WHERE fecha >= (CURRENT_DATE - (dias || ' days')::INTERVAL)
    );
    RETURN num;
END;
$$ LANGUAGE plpgsql;

-- --------------------------------------------------------

-- 
-- Total factura (Función)
-- 

CREATE OR REPLACE FUNCTION total_factura(fact INTEGER)
RETURNS FLOAT AS $$
DECLARE
    total FLOAT;
BEGIN
    SELECT sum(importe) INTO total 
    FROM lineas_factura 
    WHERE factura = fact;
    
    RETURN total;
END;
$$ LANGUAGE plpgsql;

-- --------------------------------------------------------

-- 
-- Ventas por vendedor (Vista)
-- 

CREATE OR REPLACE VIEW ventas_vendedor AS 
SELECT * FROM vendedores
WHERE NOT EXISTS (
    SELECT 1 FROM grupos 
    WHERE NOT EXISTS (
        SELECT 1 FROM articulos 
        WHERE grupo = grupos.id 
        AND EXISTS (
            SELECT 1 FROM lineas_factura, facturas
            WHERE lineas_factura.factura = facturas.id 
            AND articulo = articulos.id 
            AND vendedor = vendedores.id 
            AND lineas_factura.fecha > (CURRENT_DATE - INTERVAL '365 days')
        )
    )
);