package theHexaghost.ghostflames;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.vfx.combat.InflameEffect;
import theHexaghost.GhostflameHelper;
import theHexaghost.HexaMod;
import theHexaghost.powers.EnhancePower;
import theHexaghost.util.TextureLoader;

public class BolsteringGhostflame extends AbstractGhostflame {
    public BolsteringGhostflame(float x, float y) {
        super(x, y);
        block = 6;
    }

    @Override
    public void onCharge() {
        int x = block;
        if (AbstractDungeon.player.hasPower(EnhancePower.POWER_ID)) {
            x += AbstractDungeon.player.getPower(EnhancePower.POWER_ID).amount;
        }
        atb(new VFXAction(AbstractDungeon.player, new InflameEffect(AbstractDungeon.player), 0.5F));// 194
        atb(new GainBlockAction(AbstractDungeon.player, x));
        atb(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new StrengthPower(AbstractDungeon.player, 1), 1));
    }

    public static Texture bruh = TextureLoader.getTexture(HexaMod.makeUIPath("bolster.png"));

    @Override
    public Texture getHelperTexture() {
        return bruh;
    }

    @Override
    public String returnHoverHelperText() {
        if (charged)
            return "0";
        return "1";
    }

    @Override
    public String getDescription() {
        String s = "";
        if (charged) {
            s = "Charged. ";
        }
        if (GhostflameHelper.activeGhostFlame == this) {
            s = s + "#yActive. Play a #yPower this turn to Charge.";
        } else {
            s = s + "Inactive. Play a #yPower while #yActive to Charge.";
        }
        int x = block;
        if (AbstractDungeon.player.hasPower(EnhancePower.POWER_ID)) {
            x += AbstractDungeon.player.getPower(EnhancePower.POWER_ID).amount;
        }
        return s + " NL When Charged, gain #b" + x + " #yBlock and #b1 #yStrength.";
    }
}
