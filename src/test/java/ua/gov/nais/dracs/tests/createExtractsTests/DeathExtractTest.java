package ua.gov.nais.dracs.tests.createExtractsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.pages.register.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.register.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.register.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.register.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;
import ua.gov.nais.dracs.util.PropertiesFileReader;

import java.io.IOException;

public class DeathExtractTest extends MainTest {
    /**
     * test data for input
     */
    private final String DEATH_ACT_RECORD = PropertiesFileReader.getPropValues("death-act-record");
    private final String EXTRACT_TYPE = PropertiesFileReader.getPropValues("extract-type-death");
    private final String ROLE_DEAD = PropertiesFileReader.getPropValues("dead");

    private final String DEAD_SURNAME = PropertiesFileReader.getPropValues("dead-surname");
    private final String DEAD_NAME = PropertiesFileReader.getPropValues("dead-name");
    private final String DEAD_FATHER_NAME = PropertiesFileReader.getPropValues("dead-father-name");
    /**
     * variables
     */
    private ExtractPage extractPage;
    private ExtendSearch search;
    private SearchByPersonRibbon searchByPersonRibbon;
    private ExtractPrint extractPrint;

    public DeathExtractTest() throws IOException {}

    @Test
    public void deathExtractTest() {
        ActRecord act = new ActRecord();
        extractPage = mainPage.openExtractTab();
        extractPage.createNewExtract();
        extractPage.selectActRecordType(DEATH_ACT_RECORD);
        extractPage.selectExtractType(EXTRACT_TYPE);
        extractPage.typeReason("випадково вийшло");
        search = extractPage.clickSearchButton();
        searchByPersonRibbon = search.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_DEAD);
        searchByPersonRibbon.enterPersonInformation(
                DEAD_SURNAME,
                DEAD_NAME,
                DEAD_FATHER_NAME
        );
        search.clickFindButton();
        search.clickAcceptButton();
        extractPage.generatePreview();
        extractPrint = extractPage.generateExtract();
        Assert.assertTrue(extractPrint.printExtract("death", act.getActNumber()));

    }

}
