package ua.gov.nais.dracs.tests.createExtractsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.pages.register.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.register.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.register.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.register.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;
import ua.gov.nais.dracs.util.CustomReporter;
import ua.gov.nais.dracs.util.PropertiesFileReader;

import java.io.IOException;

public class BirthExtractTest extends MainTest {
    /*
     * test data for input
     */
    private final String CHILD_ACT_RECORD = PropertiesFileReader.getPropValues("birth-act-record");
    private final String EXTRACT_TYPE = PropertiesFileReader.getPropValues("extract-type-birth");
    private final String ROLE_CHILD = PropertiesFileReader.getPropValues("child");

    private final String CHILD_SURNAME = PropertiesFileReader.getPropValues("child-surname");
    private final String CHILD_NAME = PropertiesFileReader.getPropValues("child-name");
    private final String CHILD_FATHER_NAME = PropertiesFileReader.getPropValues("child-father-name");
    /*
     * variables
     */
    private ExtractPage extractPage;
    private ExtendSearch search;
    private SearchByPersonRibbon searchByPersonRibbon;
    private ExtractPrint extractPrint;

    public BirthExtractTest() throws IOException {
    }

    @Test
    public void birthExtractTest() {
        ActRecord act = new ActRecord();
        extractPage = mainPage.openExtractTab();
        CustomReporter.log("Переход на вкладку Витяги");
        extractPage.createNewExtract();
        CustomReporter.log("Нажать на кнопку 'Создать витяг'");
        extractPage.selectActRecordType(CHILD_ACT_RECORD);
        CustomReporter.log("Вибрати запис про народження");
        extractPage.selectExtractType(EXTRACT_TYPE);
        CustomReporter.log("тип витягу - Про народженя");
        extractPage.typeReason("випадково вийшло");
        CustomReporter.log("ВВедето причину");
        search = extractPage.clickSearchButton();
        CustomReporter.log("НАтиснути пошук заяви");
        searchByPersonRibbon = search.openPersonRibbon();
        CustomReporter.log("Відкрито рібон персони");
        searchByPersonRibbon.selectPersonRole(ROLE_CHILD);
        CustomReporter.log("Тип дитина");
        searchByPersonRibbon.enterPersonInformation(
                CHILD_SURNAME,
                CHILD_NAME,
                CHILD_FATHER_NAME
        );
        CustomReporter.log("Данні дитини");
        search.clickFindButton();
        CustomReporter.log("натиснкути кнопку пошуку");
        search.clickAcceptButton();
        CustomReporter.log("Підтвердити результат пошуку");
        extractPage.generatePreview();
        CustomReporter.log("Сгенероване превью");
        extractPrint = extractPage.generateExtract();
        CustomReporter.log("сгенеровано витяг");
        Assert.assertTrue(extractPrint.printExtract("birth", act.getActNumber()));
        CustomReporter.log("витяг збережено");
    }
}
