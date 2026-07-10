import os
import shutil

src_dir = r"C:\Users\herod\OneDrive\Desktop\Maestro_Domino\Models"
dest_dir = r"C:\Users\herod\.gemini\antigravity\brain\40e11387-0de6-4c91-a024-e800ba5d80f1\models"

if not os.path.exists(dest_dir):
    os.makedirs(dest_dir)

for item in os.listdir(src_dir):
    src_path = os.path.join(src_dir, item)
    dest_path = os.path.join(dest_dir, item)
    if os.path.isfile(src_path):
        shutil.copy2(src_path, dest_path)
        print(f"Copied {item}")
