package com.ingles.examen.controller.excel;

import com.ingles.examen.entity.Examen;
import com.ingles.examen.entity.Ingresante;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class IngresanteExcelImporter {

    public List<Ingresante> excelImport(MultipartFile file) {
        List<Ingresante> listaIngresante = new ArrayList<>();

        //String excelFilePath = "C:\\Users\\jorge\\Desktop\\libro1.xlsx";
        long start = System.currentTimeMillis();

        FileInputStream inputStream;
        try {
            inputStream = (FileInputStream) file.getInputStream();
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();
            rowIterator.next();
            /**
             * **************Datos Duros********************************
             */
            Long id = null;
            String mail = null;
            Long celu = null;
            String tDoc = null;
            String numDoc = null;
            String apellido = null;
            String nombre = null;
            String fNacimiento = null;
            String genero = null;
            String nacionalidad = null;
            String pais = null;
            String provincia = null;
            String localidadResi = null;
            String domicilio = null;
            Boolean d_estado = false;
            /**
             * **************Tayectoria
             * Educativa********************************
             */
            String e_nivelMaximo = null;
            String e_egresadoDe = null;
            String e_establecimiento = null;
            Integer e_anioEgreso = null;
            Boolean e_estado = false;
            /**
             * **************Situacion Laboral********************************
             */
            String t_situacionActual = null;
            String t_relacion = null;
            String t_actividadPrincipal = null;
            String t_roles = null;
            String t_duracion = null;
            Integer t_antiguedad = null;
            Integer t_añosDelSector = null;
            String t_aportesJ = null;
            String t_plataPara = null;
            String t_horas = null;
            String t_franja = null;
            Boolean t_estado = false;
            /**
             * **************nivel Ingles********************************
             */
            String i_estudiaste = null;
            String i_donde = null;
            String i_nivel_oral = null;
            String i_nivel_escrito = null;
            String i_nivel_lectura = null;
            String i_uso_trabajo = null;
            String i_uso_t_situacion = null;
            String i_conseguirOportunidades = null;
            String i_programacion = null;
            String i_cercerProfecionalmente = null;
            String i_valorTiempo = null;
            Boolean i_estado = null;
            Examen examen = null;

            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                id = null;
                mail = null;
                celu = null;
                tDoc = null;
                numDoc = null;
                apellido = null;
                nombre = null;
                fNacimiento = null;
                genero = null;
                nacionalidad = null;
                pais = null;
                provincia = null;
                localidadResi = null;
                domicilio = null;
                d_estado = false;
                /**
                 * **************Tayectoria
                 * Educativa********************************
                 */
                e_nivelMaximo = null;
                e_egresadoDe = null;
                e_establecimiento = null;
                e_anioEgreso = null;
                e_estado = false;
                /**
                 * **************Situacion
                 * Laboral********************************
                 */
                t_situacionActual = null;
                t_relacion = null;
                t_actividadPrincipal = null;
                t_roles = null;
                t_duracion = null;
                t_antiguedad = null;
                t_añosDelSector = null;
                t_aportesJ = null;
                t_plataPara = null;
                t_horas = null;
                t_franja = null;
                t_estado = false;
                /**
                 * **************nivel Ingles********************************
                 */
                i_estudiaste = null;
                i_donde = null;
                i_nivel_oral = null;
                i_nivel_escrito = null;
                i_nivel_lectura = null;
                i_uso_trabajo = null;
                i_uso_t_situacion = null;
                i_conseguirOportunidades = null;
                i_programacion = null;
                i_cercerProfecionalmente = null;
                i_valorTiempo = null;
                i_estado = null;
                examen = null;
                while (cellIterator.hasNext()) {
                    /**
                     * **************Datos
                     * Duros********************************
                     */

                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();
                    switch (columnIndex) {

                        case 0:
                            System.out.println(nextCell.getCellType() + " id " + nextCell.getNumericCellValue());
                            id = (long) nextCell.getNumericCellValue();

                            break;
                        case 1:
                            System.out.println(nextCell.getCellType() + " nombre " + nextCell.getStringCellValue());
                            nombre = nextCell.getStringCellValue();

                            break;
                        case 2:
                            System.out.println(nextCell.getCellType() + " apellido " + nextCell.getStringCellValue());
                            apellido = nextCell.getStringCellValue();

                            break;
                        case 3:

                            if (nextCell.getCellType().toString().equalsIgnoreCase("STRING")) {
                                numDoc = nextCell.getStringCellValue();
                                System.out.println(nextCell.getCellType() + " numDoc " + nextCell.getStringCellValue());
                            }
                            if (nextCell.getCellType().toString().equalsIgnoreCase("NUMERIC")) {
                                Long num = (long) nextCell.getNumericCellValue();
                                System.out.println(num);
                                numDoc = num.toString();
                                System.out.println(nextCell.getCellType() + " numDoc " + nextCell.getNumericCellValue());
                            }

                            break;
                        case 4:
                            System.out.println(nextCell.getCellType() + " email " + nextCell.getStringCellValue());
                            mail = nextCell.getStringCellValue();

                            break;
                        case 5:
                            System.out.println(nextCell.getCellType() + " e_egresadoDe " + nextCell.getStringCellValue());
                            e_egresadoDe = nextCell.getStringCellValue();

                            break;
                        case 6:
                            System.out.println(nextCell.getCellType() + " e_establecimiento " + nextCell.getStringCellValue());
                            e_establecimiento = nextCell.getStringCellValue();

                            break;

                    }

                }
                if (mail.equalsIgnoreCase("")) {
                    mail = "falso@falso.com";
                }

                listaIngresante.add(new Ingresante(id, mail, numDoc, apellido, nombre, e_egresadoDe, e_establecimiento));

            }

            workbook.close();
            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));

        } catch (Exception e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        }
        System.out.println("El tamañ de la lista antes de enviar es " + listaIngresante.size());
        return listaIngresante;
    }

}
