package sample.views;

import sample.models.ExplorerState;

import java.io.File;

public interface MainViewInteraction {
    void showSubListing(File file);
    void onSelect(ExplorerState explorerState);
}
