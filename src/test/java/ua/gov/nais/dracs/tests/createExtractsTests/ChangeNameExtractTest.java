package ua.gov.nais.dracs.tests.createExtractsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;
import ua.gov.nais.dracs.util.PropertiesFileReader;

import java.io.IOException;

public class ChangeNameExtractTest extends MainTest {
    /**
     * test data for input
     */
    private final String CHANGE_NAME_ACT_RECORD = PropertiesFileReader.getPropValues("change-name-act-record");
    private final String EXTRACT_TYPE = PropertiesFileReader.getPropValues("extract-type-name-change");
    private final String ROLE_SUBJ_AR = PropertiesFileReader.getPropValues("subject");

    private final String SUBJECT_SURNAME = PropertiesFileReader.getPropValues("subject-surname");
    private final String SUBJECT_NAME = PropertiesFileReader.getPropValues("subject-name");
    private final String SUBJECT_FATHER_NAME = PropertiesFileReader.getPropValues("subject-father-name");
    /**
     * variables
     */
    private ExtractPage extractPage;
    private ExtendSearch search;
    private SearchByPersonRibbon searchByPersonRibbon;
    private ExtractPrint extractPrint;

    public ChangeNameExtractTest() throws IOException {
    }

    @Test
    public void changeNameExtractTest() {
        ActRecord act = new ActRecord();
        extractPage = mainPage.openExtractTab();
        extractPage.createNewExtract();
        extractPage.selectActRecordType(CHANGE_NAME_ACT_RECORD);
        extractPage.selectExtractType(EXTRACT_TYPE);
        extractPage.typeReason("випадково вийшло");
        search = extractPage.clickSearchButton();
        searchByPersonRibbon = search.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_SUBJ_AR);
        searchByPersonRibbon.enterPersonInformation(
                SUBJECT_SURNAME,
                SUBJECT_NAME,
                SUBJECT_FATHER_NAME
        );
        search.clickFindButton();
        search.clickAcceptButton();
        extractPage.generatePreview();
        extractPrint = extractPage.generateExtract();
        Assert.assertTrue(extractPrint.printExtract("namechange", act.getActNumber()));
    }

}
