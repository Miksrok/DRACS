package ua.gov.nais.dracs.tests.createExtractsFromARTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.gov.nais.dracs.models.ActRecord;
import ua.gov.nais.dracs.pages.actRecordsTab.ActRecordsTab;
import ua.gov.nais.dracs.pages.actRecordsTab.acts.nameChangePage.NameChangePage;
import ua.gov.nais.dracs.pages.extractTab.ExtractPage;
import ua.gov.nais.dracs.pages.modalWindows.ExtractPrint;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.ExtendSearch;
import ua.gov.nais.dracs.pages.modalWindows.extendSearchActRecords.extendSearchRibbons.SearchByPersonRibbon;
import ua.gov.nais.dracs.tests.MainTest;
import ua.gov.nais.dracs.util.PropertiesFileReader;

import java.io.IOException;

public class NameChangeExtractFromARTest extends MainTest {
    /**
     * test data for input
     */
    private final String ROLE_SUBJ_AR = PropertiesFileReader.getPropValues("subject");

    private final String SUBJECT_SURNAME = PropertiesFileReader.getPropValues("subject-surname");
    private final String SUBJECT_NAME = PropertiesFileReader.getPropValues("subject-name");
    private final String SUBJECT_FATHER_NAME = PropertiesFileReader.getPropValues("subject-father-name");
    /**
     * variables
     */
    private ActRecordsTab actRecordsTab;
    private NameChangePage nameChangePage;
    private ExtendSearch extendSearch;
    private SearchByPersonRibbon searchByPersonRibbon;
    private ExtractPage extractPage;
    private ExtractPrint extractPrint;

    public NameChangeExtractFromARTest() throws IOException {
    }

    @Test
    public void nameChangeExtractFromARTest() {
        ActRecord act = new ActRecord();
        actRecordsTab = mainPage.openActRecordsTab();
        nameChangePage = actRecordsTab.selectNameChange();
        extendSearch = nameChangePage.openExtendSearchModalWindow();
        searchByPersonRibbon = extendSearch.openPersonRibbon();
        searchByPersonRibbon.selectPersonRole(ROLE_SUBJ_AR);
        searchByPersonRibbon.enterPersonInformation(
                SUBJECT_SURNAME,
                SUBJECT_NAME,
                SUBJECT_FATHER_NAME
        );
        extendSearch.clickExtFindButton();
        nameChangePage.selectSearchResult(
                SUBJECT_SURNAME,
                SUBJECT_NAME,
                SUBJECT_FATHER_NAME
        );
        extractPage = nameChangePage.clickCreateExtract();
        extractPage.typeReason("само вийшло");
        extractPage.generatePreview();
        extractPrint = extractPage.generateExtract();
        Assert.assertTrue(extractPrint.printExtract("namechange-from-ar", act.getActNumber()));
    }

}
